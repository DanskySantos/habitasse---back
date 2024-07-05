package com.project.habitasse.security.confirmationCode.repository;


import com.project.habitasse.security.confirmationCode.entities.ConfirmationCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConfirmationCodeRepository extends JpaRepository<ConfirmationCode, Long> {

	Optional<ConfirmationCode> findConfirmationCodeByUserId(Integer userId);
}
