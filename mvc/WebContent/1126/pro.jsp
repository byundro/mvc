<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <h1>이름 : ${requestScope.name} </h1>
    <h1>번-호 : ${result} </h1>
    <h1>id : ${dto.id} </h1>

   <h1>list : ${list.get(O)} </h1>
   <h1>list : ${list[0]} </h1>
   
   <h1>list : ${list.get(1)} </h1>
   
    <h1>list : ${list[2]} </h1>
    <h1>list : ${list[2].id} </h1>
    <h1>list : ${list[2].passwd} </h1>