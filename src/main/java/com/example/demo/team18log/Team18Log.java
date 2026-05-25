//package com.example.demo.team18log;
//
//import java.util.Arrays;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.stereotype.Component;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Aspect
//@Component
//@Slf4j
//public class Team18Log {
//	
//	@AfterThrowing("execution(* com.example.demo.team18controller.*.*(..))")
//	public void afterThrowingLog(JoinPoint jp) {
//		log.error("エラー発生。発生タイミング：{}", Arrays.toString(jp.getArgs()));
//	}
//	
//	@Around("execution(* com.example.demo.team18controller.*.*(..))")
//	public Object AroundLog(ProceedingJoinPoint jp) throws Throwable {
//		try {
//			log.info("送ったデータ：{}・対象のメソッド：{}", Arrays.toString(jp.getArgs()), jp.getSignature());
//			Object result = jp.proceed(); //ここでindexメソッドを動かして戻り値をresultに入れる
//			return result;
//		} catch (Exception e) {
//			return "team18error/team18error";
//		}
//	}
//	
//	
//
//}
