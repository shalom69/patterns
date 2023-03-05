[![Build status](https://ci.appveyor.com/api/projects/status/k1drgisdb9hf3kb2?svg=true)](https://ci.appveyor.com/project/Gnucheva/patterns)

Настройка CI осуществляется аналогично предыдущему заданию (за исключением того, что файл целевого сервиса может называться по-другому). Для второй задачи вам также понадобится указать нужный флаг запуска для "тестового режима".   
Вам необходимо автоматизировать тестирование новой функции формы заказа доставки карты.   
Тестируемая функциональность: если заполнить форму повторно теми же данными за исключением "Даты встречи", то система предложит перепланировать время встречи.   
После нажатия на кнопке "Перепланировать" произойдёт перепланирование встречи.   

В этот раз вы не должны хардкодить данные прямо в тест! Используйте Faker, Lombok, Data-классы (для группировки нужных полей) и утилитный класс-генератор данных.

