package io.isr.card.repositories;

import io.isr.card.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CardRepositories extends JpaRepository<Card, Long> {
	ArrayList<Card> findAllByUserId(Long userId);
	Card findCardByUserId(Long userId);
	Card findByCardNumber(String cardNumber);
	Card findCardById(Long id);
}
