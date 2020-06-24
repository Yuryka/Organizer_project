$(document).ready(() => {
    let editNoteId = null;

    $('#modal-save-button').click(() => {
        const note = $('#modal-event-note').val();
        const date = $('#modal-event-date').val();
        const checked = $('#modal-event-checked').val();
        const body = {
            note: note,
            date: date,
            checked: checked
        };

        if (editNoteId === null) {
            addNewNote(body);
        } else {
            editNote(editNoteId, body);
        }
    });

    $('.fa-trash-alt').click(function () {
        const eventId = this.parentElement.id;
        fetch('/api/organizer/' + eventId, {
            method: 'delete'
        }).then(response => location.reload());
    });

    $('.fa-edit').click(function () {
        editMovieId = this.parentElement.id;

        const row = this.parentElement.parentElement.parentElement;
        const note = row.children[0].innerText;
        const date = row.children[1].innerText;
        const checked = row.children[2].innerText;

        $('#modal-event-note').val(note);
        $('#modal-event-date').val(date);
        $('#modal-event-checked').val(checked);
    });

    function addNewNote(body) {
        fetch('/api/organizer', {
            method: 'post',
            body: JSON.stringify(body),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => {
            location.reload();
        });
    }

    function editNote(id, body) {
        fetch('/api/organizer/' + id, {
            method: 'put',
            body: JSON.stringify(body),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(() => {
            location.reload();
            editNoteId = null;
        });
    }
})
