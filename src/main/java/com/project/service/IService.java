package com.project.service;

import java.util.List;
import java.util.Optional;

public interface IService<T> {
	List<T> findAll();

	Optional<T> findbyId(Long id);

	T SaveOrUpdate(T t);

	String delete(Long id);
}
