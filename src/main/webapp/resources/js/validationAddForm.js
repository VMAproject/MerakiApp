/**
 * Created by oleksandr on 29.03.17.
 */

$(function() {

    $('.adding-form').each(function(){
        // Объявляем переменные (форма и кнопка отправки)
        var form = $(this),
            btn = form.find('.btn');

        // Добавляем каждому проверяемому полю, указание что поле пустое
        form.find('.form-control').addClass('empty_field');

        // Функция проверки полей формы
        function checkInput(){
            // var select = form.find('.empty_field .selectpicker :selected').val();
            // console.log(select);
            form.find('.form-control').each(function(){
                if($(this).val() != ''){
                    // Если поле не пустое удаляем класс-указание
                    $(this).removeClass('empty_field');
                } else {
                    // Если поле пустое добавляем класс-указание
                    $(this).addClass('empty_field');
                }
            });
            form.find('.btn-group.form-control').removeClass('empty_field');
        }

        // Функция подсветки незаполненных полей
        function lightEmpty(){
            var empty = form.find('.empty_field');
            form.find('.message').remove();
            var txt = $("<div class='message'></div>").text("This field required");
            empty.after(txt);
            empty.css({'border-color':'#d8512d'});
            // Через полсекунды удаляем подсветку
            setTimeout(function(){
                form.find('.empty_field').removeAttr('style');
            },2000);
        }

        // Проверка в режиме реального времени
        setInterval(function(){
            // Запускаем функцию проверки полей на заполненность
            checkInput();
            // Считаем к-во незаполненных полей
            var sizeEmpty = form.find('.empty_field').size();
            // Вешаем условие-тригер на кнопку отправки формы
            if(sizeEmpty > 0){
                if(btn.hasClass('incorrect')){
                    return false
                } else {
                    btn.addClass('incorrect');
                }
            } else {
                btn.removeClass('incorrect');
            }
        },500);

        // Событие клика по кнопке отправить
        btn.click(function(){
            if($(this).hasClass('incorrect')){
                // подсвечиваем незаполненные поля и форму не отправляем, если есть незаполненные поля
                lightEmpty();
                return false
            } else {
                // Все хорошо, все заполнено, отправляем форму
                form.submit();
            }
        });
    });
});