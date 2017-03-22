/**
 * Created by oleksandr on 14.03.17.
 */
$(document).ready(
    $('#registerForm').keyup(function (e) {
        var success = $(e.target).siblings('.alert-success');
        var danger = $(e.target).siblings('.alert-danger');
        var reg = /.{6,}/;
        var match = $(e.target).val().match(reg);
        if (match) {
            success.removeClass('hidden');
            danger.addClass('hidden');
        } else {
            success.addClass('hidden');
            danger.removeClass('hidden');
        }
    }).focusout(function (e) {
        console.log($("#registerForm").data('clicked') == true);
        $(e.target).siblings('.alert-success').addClass('hidden');
        $(e.target).siblings('.alert-danger').addClass('hidden');
    })
)