//package com.example.demo.team18repositories;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import com.example.demo.team18entity.Team18StatusEntity;
//
//@Repository
//
//public interface Team18ReturnRepository extends JpaRepository<Team18StatusEntity, Integer> {
//	boolean existsBylogId(Integer userId);
//	
////<<<<<<< HEAD
//	
////=======
//	@Query(value = "select user_id from team18_user_tbl where user_email = :userEmail", nativeQuery = true)
//	public List<Integer> userIdGet(@Param("userEmail") String userEmail);
////>>>>>>> d992d0748ea830a3de47000e57972681cdf48a60
//}
