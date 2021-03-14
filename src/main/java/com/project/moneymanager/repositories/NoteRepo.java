package com.project.moneymanager.repositories;

import com.project.moneymanager.models.Category;
import com.project.moneymanager.models.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepo extends CrudRepository<Note, Long> {
}
