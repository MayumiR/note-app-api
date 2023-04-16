package com.example.demo.dto;

import com.example.demo.entity.Note;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class NoteDto extends SuperDto<Note> {
    private Long id;
    private String title;
    private String description;

    @Override
    public Note toEntity() {
        Note note = new Note();
        note.setId(this.id);
        note.setTitle(this.title);
        note.setDescription(this.description);

        return note;
    }
}
