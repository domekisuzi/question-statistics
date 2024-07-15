细数下踩了多少坑

controller 没写@ResponseBody，导致直接404而且springboot没有爆任何错误

然后实体没加 @Entity 导致直接报错出  can't create bean


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Request URL: " + request.getRequestURL());
        System.out.println("Request Method: " + request.getMethod());

//       TODO ("不读取请求体，防止发生多次读取错误")
//        System.out.println("Request Body: " + request.getReader().lines());
return true;
}

重复读了下请求体报错，什么逆天


使用    @JsonIgnoreProperties({"knowledgePoints"})解决了多对多查询互相 引用的问题，使得传到前端时能够忽略固定字段  

使用@JsonIgnore注解，在关联对象上添加这个注解，使在序列化是忽略掉这个字段。但是同时关联的对象也不会在json数据中出现。

@JsonIgnoreProperties注解，这个注解可以选择性的忽略固定字段，也就是说可以在查询班级的时候，忽略掉班级所级联出来的学生的班级字段，从而避免死循环。这个方法技能解决死循环，又能将级联到的数据返回到json。
 
这样，前端就不会因为无限循环而只返回一个对象了