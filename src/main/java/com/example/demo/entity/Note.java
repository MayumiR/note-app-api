package com.example.demo.entity;

import com.example.demo.dto.NoteDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Note extends SuperEntity<NoteDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String description;

    @Override
    public NoteDto toDto() {
        NoteDto noteDto = new NoteDto();
        noteDto.setId(this.id);
        noteDto.setTitle(this.title);
        noteDto.setDescription(this.description);
        setAuditDetail(noteDto);
        return noteDto;
    }
}
