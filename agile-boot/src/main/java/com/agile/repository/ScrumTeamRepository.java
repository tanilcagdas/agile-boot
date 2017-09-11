package com.agile.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agile.beans.ProductOwnerUserData;
import com.agile.beans.ScrumTeamData;


public interface ScrumTeamRepository extends JpaRepository<ScrumTeamData, String> {
	
	List<ScrumTeamData> findByProductOwner(ProductOwnerUserData user); 
}

