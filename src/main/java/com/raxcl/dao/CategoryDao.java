package com.raxcl.dao;

import com.raxcl.domain.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> findAll();
}
