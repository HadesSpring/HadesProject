关于在引入jQuery文件时，上面显示一个小小的红色X号，这个并不会影响项目的运行，jQuery里面有些javascript代码写法并不规范，但是会影响到大家的心情.
去除JS验证的方法：
1)　找到项目的.project文件;
2)	注释掉
  <buildCommand>
   <name>org.eclipse.wst.jsdt.core.javascriptValidator</name>
   <arguments>
   </arguments>
  </buildCommand>
  和
  <nature>org.eclipse.wst.jsdt.core.jsNature</nature>
3)	将文件上带有X号的文件删除并重新引入即可;

或者是：
window -- Preferences -- MyEclipse -- Validation -- 去除 JavaScript validator for js files 选项的勾选;