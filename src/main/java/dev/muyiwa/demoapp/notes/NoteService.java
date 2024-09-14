package dev.muyiwa.demoapp.notes;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    public Optional<Note> getNoteById(UUID id) {
        return noteRepository.findById(id);
    }

    public Note updateNoteById(UUID id, NoteDto noteDto) {
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isEmpty()) {
            throw new EntityNotFoundException("note not found with id: " + id);
        }

        Note note = optionalNote.get();

        note.setTitle(noteDto.getTitle() != null && !noteDto.getTitle().isEmpty() ? noteDto.getTitle() : note.getTitle());
        note.setContent(noteDto.getContent() != null && !noteDto.getContent().isEmpty() ? noteDto.getContent() : note.getContent());

        return noteRepository.save(note);
    }

    public void deleteNoteById(UUID id) {
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isEmpty()) {
            throw new EntityNotFoundException("note not found with id: " + id);
        }
        noteRepository.deleteById(id);
    }

    public Page<NoteDto> getNotes(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return noteRepository.findAll(pageable).map(Note::toDto);
    }

}
