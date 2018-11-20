package com.upload.db.uploaddb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.upload.db.uploaddb.model.Img;

@Repository
public interface ImgRepository extends JpaRepository<Img, Long> {
	
	@Query("SELECT i FROM Img i WHERE i.nome = ?1 ORDER BY index")
	List<Img> findImageByName(String name);
	
	
}