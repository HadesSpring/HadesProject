package com.hades.framework.core.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hades.framework.core.model.Page;

/**
 * 
 * HadesProject
 * 
 * @author 李先瞧 2015-7-23 数据操作接口
 * @param <T>实体泛型
 */
public interface IHadesBaseDao<T extends Object, ID extends Serializable> {

	/**
	 * 获取数据库连接
	 * hibernate4中移出了session.getconnection();
	 * 替代方案:
	 * this.currentSession().doWork(new Work() {
	 *	    public void execute(Connection connection) throws SQLException {
	 *			// 执行JDBC操作       // 注意不要close了这个connection。 }
	 *	});
	 * 李先瞧
	 * 2015-7-27
	 * 
	 * @return 获取返回链接 ,使用完后注意关闭connection
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException;
	/**
	 * 获取会话session , 方法采取getCurrentSession();
	 * 
	 * 注意:采用getCurrentSession()创建的session在commit或rollback时会自动关闭，
	 * 而采用openSession()，创建的session必须手动关闭 . 
	 * 
	 * 
	 * 李先瞧
	 * 2015-7-27
	 * 
	 * @return
	 */
	public Session getSession();
	/**
	 * 保存指定实体类
	 * 
	 * @param entityobj
	 *            实体类
	 */
	public ID save(final T entity);

	/**
	 * 删除指定实体
	 * 
	 * @param entityobj
	 *            实体类
	 */
	public void delete(final T entity);

	/**
	 * 获取所有实体集合
	 * 
	 * @param entityClass
	 *            实体
	 * @return 集合
	 */
	public List<T> queryAll(final Class<T> entityClass);

	/**
	 * 更新或保存指定实体
	 * 
	 * @param entity
	 *            实体类
	 */
	public void saveOrUpdate(final T entity);

	/**
	 * 查找指定ID实体类对象
	 * 
	 * @param entityClass
	 *            实体Class
	 * @param id
	 *            实体ID
	 * @return 实体对象
	 */
	public T queryById(final Class<T> entityClass, final ID id);

	/**
	 * 查询指定HQL，并返回集合
	 * 
	 * @param hql
	 *            HQL语句
	 * @param values
	 *            可变的参数列表
	 * @return 集合
	 */
	public List<T> query(final String hql, final Object... values);

	/**
	 * 按照HQL语句查询唯一对象.
	 * 
	 * @param hql
	 *            HQL语句
	 * @param values
	 *            可变参数集合
	 * @return OBJECT对象
	 */
	public Object queryUnique(final String hql, final Object... values);

	/** 统计指定类的所有持久化对象 */
	public Long countAll(final String hql);

	/**
	 * 获取指定实体Class指定条件的记录总数
	 * 
	 * @param entityClass
	 *            实体Class
	 * @param where
	 *            HQL的查询条件,支持参数列表
	 * @param values
	 *            可变参数列表
	 * @return 记录总数
	 */
	public Long queryTotalCount(final Class<T> entityClass, final String where,
			final Object... values);

	/**
	 * 获取指定实体Class的记录总数
	 * 
	 * @param entityClass
	 *            实体Class
	 * @return 记录总数
	 */
	public Long queryTotalCount(final Class<T> entityClass);

	/**
	 * 查找指定属性的实体集合
	 * 
	 * @param entityClass
	 *            实体
	 * @param propertyName
	 *            属性名
	 * @param value
	 *            条件
	 * @return 实体集合
	 */
	public List<T> queryByProperty(final Class<T> entityClass, final String propertyName,
			final Object value);

	/**
	 * 模糊查询指定条件对象集合 <br>
	 * 用法：可以实例化一个空的T对象，需要查询某个字段，就set该字段的条件然后调用本方法<br>
	 * 缺点：目前测试貌似只能支持String的模糊查询，虽然有办法重写，但没必要，其他用HQL<br>
	 * 
	 * @param entity
	 *            条件实体
	 * @return 结合
	 */
	public List<T> queryByEntity(final T entity);

	/**
	 * 补充方法(未测) 据说可以无视session的状态持久化对象
	 * 
	 * @param entity
	 *            实体类
	 * @return 持久后的实体类
	 */
	public T merge(final T entity);

	/**
	 * 清除实体的锁定状态<br>
	 * 方法未测
	 * 
	 * @param entity
	 *            实体
	 */
	public void attachClean(final T entity);

	/**
	 * 
	 * 李先瞧 2015-7-25 分页装载指定类的所有持久化对象
	 * 
	 * @param hql
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<?> queryAll(final String hql, int pageNo, int pageSize);

	/**
	 * 按HQL分页查询.
	 * 
	 * @param page
	 *            页面对象
	 * @param hql
	 *            HQL语句
	 * @param values
	 *            可变参数列表
	 * @return 分页数据
	 */
	public Page<T> queryByPage(final Page<T> page, final String hql,
			final Object... values);

	/**
	 * 根据查询条件与参数列表创建Query对象
	 * 
	 * @param session
	 *            Hibernate会话
	 * @param hql
	 *            HQL语句
	 * @param objects
	 *            参数列表
	 * @return Query对象
	 */
	public Query createQuery(final Session session,final String hql, final Object... objects);

	/** 统计指定类的查询结果 */
	public int countQuery(final String hql);

	
	/**
	 * 根据原生sql进行查询 ,  select 后面最好跟列字段,可以方便跟obj[]数组对应取值
	 * 李先瞧
	 * 2015-7-27
	 * 
	 * @param sql
	 * @return 根据select后面的列顺序进行封装后的集合
	 */
	public List<Object[]>  queryBySql(String sql );
	
	
	/**
	 * 
	 * 李先瞧 2015-7-25 删除指定ID的持久化对象
	 * 
	 * @param clazz实体类型
	 * @param id
	 *            id号
	 */
	public void deleteById(final Class<?> clazz, final Serializable id);

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
	public List<T> queryByPage(final String hql, final int offset, final int pageSize);

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
	@SuppressWarnings("rawtypes")
	public List queryByPageSQL(final String sql,

	final int offset, final int pageSize);

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
	public List<T> queryByPage(final String hql, final Object value,

	final int offset, final int pageSize);

	/**
	 * 李先瞧 2015-7-25 使用hql 语句进行分页查询操作
	 * 
	 * @param hql
	 *            需要查询的hql语句
	 * 
	 * @param values
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
	public List<T> queryByPage(final String hql, final Object[] values,
			final int offset, final int pageSize);

	/**
	 * 
	 * 李先瞧 2015-7-25
	 * 
	 * 更新指定属性值
	 * 
	 * @param hql
	 * @param values
	 */
	public void updateObj(final String hql, final Object[] values);

	/**
	 * 李先瞧 2015-7-25 根据语句查找总数
	 * 
	 * @param hql
	 *            hql语句
	 * 
	 * @return 对应的数目
	 */
	public Integer getCount(final String hql);

	/**
	 * 李先瞧 2015-7-25 返回list集合
	 * 
	 * */
	@SuppressWarnings("rawtypes")
	public List queryDataByHQL(final String hql);

}
