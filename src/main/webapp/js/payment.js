function validate() {
    const name = $('#username').val();
    const email = $('#email').val();
    const phone = $('#phone').val();
    let valid = true;

    $(".invalid-feedback").remove();
    $("#username").removeClass("is-invalid");
    $("#email").removeClass("is-invalid");
    $("#phone").removeClass("is-invalid");

    $(".error").remove();
    if (name == '') {
        $('#username').addClass("is-invalid").after('<div class="invalid-feedback">Введите имя</div>');
        valid = false;
    }
    if (email == '') {
        $('#email').addClass("is-invalid").after('<div class="invalid-feedback">Введите email</div>');
        valid = false;
    }
    if (phone == '') {
        $('#phone').addClass("is-invalid").after('<div class="invalid-feedback">Введите телефон</div>');
        valid = false
    }
    return valid;
}

function sendSubmit() {
    if (validate() == true) {
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/cinema/payment',
            data: 'name=' + $('#username').val()
                + '&email=' + $('#email').val()
                + '&phone=' + $('#phone').val()
                + '&id=' + window.id
                + '&row=' + window.row
                + '&cell=' + window.cell,
            dataType: 'text'
        }).done(function (data) {
           $(".error").remove();
            if (data != 409) {
                window.location.href = '/cinema/index.html';
            } else {
                $('form').parent().after('<div class="error" style="color:#ff0000; font-weight: bold">' +
                    'Пользователь уже существует покупка не удалась </div>')
            }
        }).fail(function (err) {
            alert(err);
        });
    }
}

function createRequest() {
    const urlParams = new URLSearchParams(window.location.search);
    window.row = urlParams.get('row');
    window.cell = urlParams.get('cell');
    window.id = urlParams.get('id')
    $('h3').text('Вы выбрали ряд ' + window.row + ' место ' + window.cell + ' Сумма : 500 рублей.');
}