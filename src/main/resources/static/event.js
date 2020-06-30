$(document).ready(() => {
    let editEventId = null;

    $('#modal-save-button').click(() => {
        const note = $('#modal-event-note').val();
        const details = $('#modal-event-details').val();
        const date = $('#modal-event-date').val();
        const checked = $('#modal-event-checked')[0].checked;
        const userid = $('#modal-event-user').val();
        const userName = $('#modal-event-user:selected').text();

        const body = {
            note: note,
            date: date,
            checked: checked,
            details: details,
            responsible: {
                id: userid,
                nickName:userName
                }
            };

        if (editEventId === null) {
            addNewNote(body);
        } else {
            editNote(editEventId, body);
        }
    });

    $('.fa-trash-alt').click(function () {
        const eventId = this.parentElement.id;
        fetch('/api/organizer/' + eventId, {
            method: 'delete'
        }).then(response => location.reload());
    });

    $('.fa-edit').click(function () {
        $('#modal-title').text("Edit event");
        editEventId = this.parentElement.id;

        const row = this.parentElement.parentElement.parentElement;
        const note = row.children[0].innerText;
        const details = row.children[0].children[0].getAttribute('details');
        const date = row.children[1].getAttribute('fulltime');
        const checked = row.children[2].innerText;


        $('#modal-event-note').val(note);
        $('#modal-event-details').val(details);
        $('#modal-event-date').val(date.replace(' ', 'T'));
        $('#modal-event-checked')[0].checked = (checked == 'true');
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
        $('#modal-title').text("Add event");
            location.reload();
            editEventId = null;
        });
    }
})
