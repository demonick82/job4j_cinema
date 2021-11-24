function payment() {
    const row = $('input[name="place"]:checked').attr('row');
    const cell = $('input[name="place"]:checked').attr('cell');
    const id = 1;
    if (row == null || cell == null) {
        alert("Выберете места")
        return false;
    }
    window.location.href = '/cinema/payment.html?row=' + row + '&cell=' + cell + '&id=' + id;
    return true;
}
function showPlaces() {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/cinema/hall',
        dataType: 'json'
    }).done(function (data) {
        for (let ticket of data) {
            let value = ticket.row.toString() + ticket.cell.toString();
            $('#' + value).prop('disabled', true).parent().css("background-color", "#B0E0E6")
                .text("Место занято");
            console.log(data);
        }
    }).fail(function (err) {
        console.log(err);
    });
}