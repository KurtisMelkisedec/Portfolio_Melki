package com.portoflio.back.data.repositories;

import com.portoflio.back.data.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImageRepository extends JpaRepository<Image, Long> {
}
