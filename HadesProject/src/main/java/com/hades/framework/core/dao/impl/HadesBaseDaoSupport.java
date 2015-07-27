/*
 * 李先瞧
 * 2015-7-23
 *
 */

package com.hades.framework.core.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.web.context.WebApplicationContext;

import com.hades.framework.core.dao.IHadesBaseDao;
import com.hades.framework.core.model.Page;

/**
 * 注意: 此类的封装实现  是基于hibernate的 对于单表的操作 很好
 *       但是对于复杂查询 以及高并发的查询语句 , 该类中的方法是不合适的,
 *       众所周知 hibernate的查询效率是很低的, 在要求大数据查询或复杂查询时最好采用jdbc;
 *       如果混合数据源操作的话, 需要关闭hibernate的二级缓存,以免造成数据的脏读;
 * HadesProject
 * 所有底层持久化操作必须继承此类, 
 * 通过此类的方法进行持久化, 
 * 为后续替换持久层做准备
 * 
 * @author 李先瞧 2015-7-23 数据操作接口公共实现类支持
 * @param <T>
 *            实体
 */
public class HadesBaseDaoSupport<T, ID extends Serializable> extends
		HibernateDaoSupport implements IHadesBaseDao<T, Serializable> {

	private static final Logger logger = Logger
			.getLogger(HadesBaseDaoSupport.class);

	@Autowired   
    public void setSessionFactoryOverride(SessionFactory sessionFactory)    
    {    
        super.setSessionFactory(sessionFactory);    
    }

	/**
	 * * 李先瞧 2015-7-25 保存指定实体类
	 * 
	 * @param entityobj
	 *            实体类
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ID save(final T entity) {
		ID id = (ID) getHibernateTemplate().save(entity);
		logger.debug("保存实体类成功," + entity.getClass().getName());
		return id;
	}

	/**
	 * * 李先瞧 2015-7-25 删除指定实体
	 * 
	 * @param entityobj
	 *            实体类
	 */
	@Override
	public void delete(final T entity) {
		try {
			getHibernateTemplate().delete(entity);
			logger.debug("删除实体类成功," + entity.getClass().getName());
		} catch (RuntimeException e) {
			logger.error("删除实体异常", e);
			throw e;
		}
	}

	/**
	 * * 李先瞧 2015-7-25 获取所有实体集合
	 * 
	 * @param entityClass
	 *            实体
	 * @return 集合
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryAll(final Class<T> entityClass) {
		try {
			logger.debug("开始删除实体：" + entityClass.getName());
			return (List<T>) getHibernateTemplate().find(
					"from " + entityClass.getName());
		} catch (RuntimeException e) {
			logger.error("查找指定实体集合异常，实体：" + entityClass.getName(), e);
			throw e;
		}
	}

	/**
	 * * 李先瞧 2015-7-25 更新或保存指定实体
	 * 
	 * @param entity
	 *            实体类
	 */
	@Override
	public void saveOrUpdate(final T entity) {
		try {
			getHibernateTemplate().saveOrUpdate(entity);
			logger.debug("更新或者保存实体成功," + entity.getClass().getName());
		} catch (RuntimeException e) {
			logger.error("更新或保存实体异常", e);
			throw e;
		}
	}

	/**
	 * * 李先瞧 2015-7-25 查询指定HQL，并返回集合
	 * 
	 * @param hql
	 *            HQL语句
	 * @param values
	 *            可变的参数列表
	 * @return 集合
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> query(final String hql, final Object... values) {
		try {
			logger.debug("开始查询指定HQL语句," + hql);
			return (List<T>) getHibernateTemplate().find(hql, values);
		} catch (RuntimeException e) {
			logger.error("查询指定HQL异常，HQL：" + hql, e);
			throw e;
		}
	}

	/**
	 * * 李先瞧 2015-7-25 按照HQL语句查询唯一对象.
	 * 
	 * @param hql
	 *            HQL语句
	 * @param values
	 *            可变参数集合
	 * @return OBJECT对象
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public T queryUnique(final String hql, final Object... values) {
		try {
			logger.debug("开始查询返回唯一结果的HQL语句," + hql);
			return (T)getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session s)
						throws HibernateException {
					Query query = createQuery(s, hql, values);
					return query.uniqueResult();
				}
			});
		} catch (RuntimeException e) {
			logger.error("查询指定HQL异常，HQL：" + hql, e);
			throw e;
		}
	}

	/**
	 * * 李先瞧 2015-7-25 统计指定类的所有持久化对象
	 * */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Long countAll(final String hql) {
		Long count = (Long) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						Query query = session.createQuery(hql);
						query.setMaxResults(1);
						return query.uniqueResult();
					}
				});
		return count;
	}

	/**
	 * * 李先瞧 2015-7-25 获取指定实体Class指定条件的记录总数
	 * 
	 * @param entityClass
	 *            实体Class
	 * @param where
	 *            HQL的查询条件,支持参数列表
	 * @param values
	 *            可变参数列表
	 * @return 记录总数
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Long queryTotalCount(final Class<T> entityClass, final String where,
			final Object... values) {
		final String hql = "select count(e) from " + entityClass.getName()
				+ " as e " + where;
		Long count = (Long) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						Query query = createQuery(session, hql, values);
						query.setMaxResults(1);
						return query.uniqueResult();
					}
				});

		return count;
	}

	/**
	 * * 李先瞧 2015-7-25 获取指定实体Class的记录总数
	 * 
	 * @param entityClass
	 *            实体Class
	 * @return 记录总数
	 */
	@Override
	public Long queryTotalCount(final Class<T> entityClass) {
		return queryTotalCount(entityClass, "");
	}

	/**
	 * * 李先瞧 2015-7-25 查找指定属性的实体集合
	 * 
	 * @param entityClass
	 *            实体
	 * @param propertyName
	 *            属性名
	 * @param value
	 *            条件
	 * @return 实体集合
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryByProperty(final Class<T> entityClass,
			final String propertyName, final Object value) {
		try {
			logger.debug("开始查找指定属性：" + propertyName + "为" + value + "的实体"
					+ entityClass.getName());
			String queryStr = "from " + entityClass.getName()
					+ " as model where model." + propertyName + "=?";
			return (List<T>) getHibernateTemplate().find(queryStr, value);
		} catch (RuntimeException e) {
			logger.error("查找指定条件实体集合异常，条件：" + propertyName, e);
			throw e;
		}
	}

	/**
	 * * 李先瞧 2015-7-25 模糊查询指定条件对象集合 <br>
	 * 用法：可以实例化一个空的T对象，需要查询某个字段，就set该字段的条件然后调用本方法<br>
	 * 缺点：目前测试貌似只能支持String的模糊查询，虽然有办法重写，但没必要，其他用HQL<br>
	 * 
	 * @param entity
	 *            条件实体
	 * @return 结合
	 */
	@Override
	public List<T> queryByEntity(final T entity) {
		try {
			List<T> results = getHibernateTemplate().findByExample(entity);
			return results;
		} catch (RuntimeException re) {
			logger.error("查找指定条件实体集合异常", re);
			throw re;
		}
	}

	/**
	 * * 李先瞧 2015-7-25 补充方法(未测) 据说可以无视session的状态持久化对象
	 * 
	 * @param entity
	 *            实体类
	 * @return 持久后的实体类
	 */
	@Override
	public T merge(final T entity) {
		try {
			T result = (T) getHibernateTemplate().merge(entity);
			return result;
		} catch (RuntimeException re) {
			logger.error("merge异常", re);
			throw re;
		}
	}

	/**
	 * * 李先瞧 2015-7-25 清除实体的锁定状态<br>
	 * 方法未测
	 * 
	 * @param entity
	 *            实体
	 */
	@Override
	public void attachClean(final T entity) {
		try {
			getHibernateTemplate().lock(entity, LockMode.NONE);
		} catch (RuntimeException re) {
			logger.error("实体解锁异常", re);
			throw re;
		}
	}

	/**
	 * 
	 * 李先瞧 2015-7-25 分页装载指定类的所有持久化对象
	 * 
	 * @param hql
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<T> queryAll(final String hql, int pageNo, int pageSize) {
		final int pNo = pageNo;
		final int pSize = pageSize;
		List<T> list = getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query query = session.createQuery(hql);
				query.setMaxResults(pSize);
				query.setFirstResult((pNo - 1) * pSize);
				List<T> result = query.list();
				if (!Hibernate.isInitialized(result))
					Hibernate.initialize(result);
				return result;
			}
		});
		return list;
	}

	/**
	 * * 李先瞧 2015-7-25 按HQL分页查询.
	 * 
	 * @param page
	 *            页面对象
	 * @param hql
	 *            HQL语句
	 * @param values
	 *            可变参数列表
	 * @return 分页数据
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Page<T> queryByPage(final Page<T> page, final String hql,
			final Object... values) {
		try {
			logger.debug("开始查找指定HQL分页数据," + hql);
			return (Page<T>) getHibernateTemplate().execute(
					new HibernateCallback() {
						public Object doInHibernate(Session s)
								throws HibernateException {
							Query query = createQuery(s, hql, values);
							if (page.isFirstSetted()) {
								query.setFirstResult(page.getFirst());
							}
							if (page.isPageSizeSetted()) {
								query.setMaxResults(page.getPageSize());
							}
							page.setResult(query.list());
								logger.debug("查找指定HQL分页数据成功," + hql);
							return page;
						}
					});
		} catch (RuntimeException e) {
			logger.error("分页查询异常，HQL：" + hql, e);
			throw e;
		}
	}

	/**
	 * * 李先瞧 2015-7-25 根据查询条件与参数列表创建Query对象
	 * 
	 * @param session
	 *            Hibernate会话
	 * @param hql
	 *            HQL语句
	 * @param objects
	 *            参数列表
	 * @return Query对象
	 */
	@Override
	public Query createQuery(final Session session, final String hql,
			final Object... objects) {
		Query query = session.createQuery(hql);
		if (objects != null) {
			for (int i = 0; i < objects.length; i++) {
				query.setParameter(i, objects[i]);
			}
		}
		return query;
	}

	/**
	 * * 李先瞧 2015-7-25 统计指定类的查询结果
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int countQuery(final String hql) {
		final String counthql = hql;
		Long count = (Long) getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException {
						Query query = session.createQuery(counthql);
						query.setMaxResults(1);
						return query.uniqueResult();
					}
				});
		return count.intValue();
	}

	/**
	 * 
	 * 李先瞧 2015-7-25 删除指定ID的持久化对象
	 * 
	 * @param clazz实体类型
	 * @param id
	 *            id号
	 */
	@Override
	public void deleteById(final Class<?> clazz, final Serializable id) {
		getHibernateTemplate().delete(getHibernateTemplate().load(clazz, id));
	}

	/**
	 * 李先瞧 2015-7-25 从Spring上下文中获取本类对象<br>
	 * 此方法可能存在线程并发问题（待测）
	 * 
	 * @param context
	 *            Spring上下文
	 * @return 本类对象
	 */
	@SuppressWarnings("rawtypes")
	public static HadesBaseDaoSupport getFromApplicationContext(
			WebApplicationContext context) {
		return (HadesBaseDaoSupport) context.getBean("HadesBaseDaoSupport");
	}

	/**
	 * 查找指定ID实体类对象
	 * 
	 * @param entityClass
	 *            实体Class
	 * @param id
	 *            实体ID
	 * @return 实体对象
	 */
	@Override
	public T queryById(final Class<T> entityClass, final Serializable id) {

		try {
			logger.debug("开始查找ID为" + id + "的实体：" + entityClass.getName());
			return (T) getHibernateTemplate().get(entityClass, id);
		} catch (RuntimeException e) {
			logger.error("查找指定ID实体异常，ID：" + id, e);
			throw e;
		}
	}

	/**
	 * 李先瞧 2015-7-25 使用hql语句进行分页操作
	 * 
	 * @param hql
	 * 
	 * @param offset第一条记录索引
	 * 
	 * @param pageSize每页需要显示的记录数
	 * 
	 * @return查询的记录
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> queryByPage(final String hql,

	final int offset, final int pageSize) {

		if (hql == null) {

			return new ArrayList<T>();

		}

		List<T> list = getHibernateTemplate().execute(new HibernateCallback() {

			public Object doInHibernate(final Session session)

			throws HibernateException {

				Query query = session.createQuery(hql);

				if (!(offset == 0 && pageSize == 0)) {

					query.setFirstResult(offset).setMaxResults(pageSize);

				}

				List<T> result = query.list();

				return result;

			}

		});

		return list;

	}

	/**
	 * 李先瞧 2015-7-25 使用sql 语句进行分页查询操作
	 * 
	 * @param sql
	 * 
	 * @param offset
	 * 
	 * @param pageSize
	 * 
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List queryByPageSQL(final String sql,

	final int offset, final int pageSize) {

		List list = getHibernateTemplate().execute(new HibernateCallback() {

			public Object doInHibernate(final Session session)

			throws HibernateException {

				Query query = session.createSQLQuery(sql);

				if (!(offset == 0 && pageSize == 0)) {

					query.setFirstResult(offset).setMaxResults(pageSize);

				}

				List result = query.list();

				return result;

			}

		});

		return list;

	}

	/**
	 * 李先瞧 2015-7-25 使用hql 语句进行分页查询操作
	 * 
	 * @param hql
	 *            需要查询的hql语句
	 * 
	 * @param value
	 *            如果hql有一个参数需要传入，value就是传入的参数
	 * 
	 * @param offset
	 *            第一条记录索引
	 * 
	 * @param pageSize
	 *            每页需要显示的记录数
	 * 
	 * @return 当前页的所有记录
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> queryByPage(final String hql, final Object value,

	final int offset, final int pageSize) {

		List<T> list = getHibernateTemplate().execute(new HibernateCallback()

		{

			public Object doInHibernate(Session session)

			throws HibernateException

			{

				Query query = session.createQuery(hql).setParameter(0, value);

				if (!(offset == 0 && pageSize == 0)) {

					query.setFirstResult(offset).setMaxResults(pageSize);

				}

				List<T> result = query.list();

				return result;

			}

		});

		return list;

	}

	/**
	 * 李先瞧 2015-7-25 使用hql 语句进行分页查询操作
	 * 
	 * @param hql
	 *            需要查询的hql语句
	 * 
	 * @param values
	 *            如果hql有多个参数需要传入，values就是传入的参数
	 * 
	 * @param offset
	 *            第一条记录索引
	 * 
	 * @param pageSize
	 *            每页需要显示的记录数
	 * 
	 * @return 当前页的所有记录
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> queryByPage(final String hql, final Object[] values,
			final int offset,

			final int pageSize) {

		List<T> list = getHibernateTemplate().execute(new HibernateCallback() {

			public Object doInHibernate(Session session)

			throws HibernateException {

				Query query = session.createQuery(hql);

				for (int i = 0; i < values.length; i++) {

					query.setParameter(i, values[i]);

				}

				if (!(offset == 0 && pageSize == 0)) {

					query.setFirstResult(offset).setMaxResults(pageSize);

				}

				List<T> result = query.list();

				return result;

			}

		});

		return list;

	}

	/**
	 * 
	 * 李先瞧 2015-7-25
	 * 
	 * 更新指定属性值
	 * 
	 * @param hql
	 * @param values
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void updateObj(final String hql, final Object[] values) {

		getHibernateTemplate().execute(new HibernateCallback() {

			public Object doInHibernate(Session session)

			throws HibernateException {

				Query query = session.createQuery(hql);

				for (int i = 0; i < values.length; i++) {

					query.setParameter(i, values[i]);

				}

				query.executeUpdate();

				return null;

			}

		});

	}

	/**
	 * 李先瞧 2015-7-25 根据语句查找总数
	 * 
	 * @param hql
	 *            hql语句
	 * 
	 * @return 对应的数目
	 */
	public Integer getCount(final String hql) {

		Integer count;

		// iterate方法与list方法的区别是list取出全部，iterator取出主键，迭代的时候才取出数据

		count = ((Long) getHibernateTemplate().iterate(hql).next()).intValue();

		logger.debug("大小" + count);

		return count;

	}

	/**
	 * 李先瞧 2015-7-25 返回list集合
	 * 
	 * */
	@SuppressWarnings({ "rawtypes" })
	public List queryDataByHQL(final String hql) {

		return getHibernateTemplate().find(hql);

	}

}
