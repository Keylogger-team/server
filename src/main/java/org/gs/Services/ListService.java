package org.gs.Services;

import org.gs.entity.ListNote;
import org.gs.exceptions.KeyloggerException;

import javax.inject.Singleton;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.List;

@Singleton
public class ListService {

    public List<ListNote> getListNotes(Long id) {
        return id == null ? getAll() : getListNotesById(id);
    }

    public List<ListNote> getAll(){
        return ListNote.listAll();
    }

    public List<ListNote> getListNotesById(Long id){
        return ListNote.find("person_id = ?1", id).list(); //поиск всех заметок конкретного пользователя
    }

    @Transactional
    public ListNote addNote(ListNote note){
        try {
            note.persistAndFlush();
        }catch (PersistenceException e){
            if(e.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
                throw new KeyloggerException(e.getCause().getCause().getMessage());
            }
            throw e;
        }
        return note;
    }

    @Transactional
    public Response deleteNote(Long id){
        try {
            ListNote.delete("id", id);
        }catch (PersistenceException e) {
            if (e.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
                throw new KeyloggerException(e.getCause().getCause().getMessage());
            }
            throw e;
        }
        return Response.status(Response.Status.OK).build();
    }
}
