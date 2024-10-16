package com.portoflio.back.data.repositories;

import com.portoflio.back.data.entities.Project;
import com.portoflio.back.data.enums.Statut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProjectRepository extends JpaRepository<Project, Long> {


 Page<Project>findAllByNameStartingWith(String title, Pageable pageable);

  Page<Project> findAllByStatutNotOrderByIdDesc(Statut statut, Pageable pageable);

  Project findProjectByIsFavoriteIsTrue();
  Project findProjectByName(String title);
  List<Project> findAllByStatutOrderByIdDesc(Statut statut);

}
