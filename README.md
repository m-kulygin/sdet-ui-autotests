# sdet-ui-autotests
Проект UI-автотестов на Java в рамках Тестового задания на SDET-практикум от компании Simbirsoft, октябрь 2025.

## Цель
В соответствии с условиями задания на выбранном языке программирования (Java) создать проект UI-автотестов по тест-кейсам.  
Тест-кейсы направлены на тестирование UI у формы: https://practice-automation.com/form-fields/  
Результаты оформить в виде проекта на gihub.  
Полные условия задания: https://cloud.mail.ru/public/ymst/YSZL7v7qd

## Технологии
- Язык программирования: Java 17 (Microsoft OpenJDK 17.0.6)
- Среда разработки: IntelliJ IDEA 2024.3 (Ultimate Edition)
- Сборка: Maven 3.9.9
- Браузер: Google Chrome 141.0.7390.77
- Веб-драйвер: Selenium 4.35.0 (ChromeDriver)
- Автотесты: JUnit 4.13.2
- Тест-репорты: Allure 2.30.0
- Скриншоты промежуточных состояний формы при тестировании: AShot 1.5.4

## Инструкция по запуску проекта
1. Убедиться, что на устройстве:
   - установлена Java 17+
   - установлен сборщик Maven
   - есть подключение к интернету
   - установлен браузер Google Chrome
2. Скачать папку проекта или склонировать репозиторий на устройство.
3. Открыть проект в IDE или перейти по пути проекта в консоли.
4. Запустить автотесты через Maven (mvn test). Дождаться выполнения.
5. Запустить плагин (mvn allure:serve) для создания визуальных тест-репортов. Итоговые отчёты должны открыться автоматически

## Тест-кейсы
### Часть 1. Автоматизация. Работа с полями и формами. (тест-кейс от авторов задания)
#### Кейс 1: успешное заполнение и отправка формы
Предусловие:
1. Открыть браузер
2. Перейти по ссылке
   https://practice-automation.com/form-fields/

Шаги:
1. Заполнить поле Name
2. Заполнить поле Password
3. Из списка What is your favorite drink? выбрать Milk и Coffee
4. Из списка What is your favorite color? выбрать Yellow
5. В поле Do you like automation? выбрать любой вариант
6. Поле Email заполнить строкой формата name@example.com
7. В поле Message написать количество инструментов, описанных в пункте Automation tools,
и написать инструмент из списка Automation tools, содержащий наибольшее количество символов
8. Нажать на кнопку Submit

**Ожидаемый результат:** появился алерт с текстом Message received!

#### Тест-репорт Allure (к кейсу 1):
<img width="500" alt="image" src="https://github.com/user-attachments/assets/b4fbc99e-ebcd-439d-9021-0ee7e72d6d21" />
<img width="500" alt="image" src="https://github.com/user-attachments/assets/7f0def20-5924-4a17-990b-19d42a940cc9" />



### Часть 2. Тестовая документация. Проверка формы. (кастомные тест-кейсы)
#### Кейс 2 (позитивный): успешный сабмит с минимальным количеством данных
Предусловие:
1. Открыть браузер
2. Перейти по ссылке
   https://practice-automation.com/form-fields/

Шаги:
1.  Заполнить поле Name
2.  Нажать на кнопку Submit

**Ожидаемый результат:** появился алерт с текстом Message received!

#### Тест-репорт Allure (к кейсу 2):
<img width="500" alt="image" src="https://github.com/user-attachments/assets/c5f99e99-c3a1-4e7c-bafd-70e48c208c19" />


#### Кейс 3 (негативный): попытка сабмита с некорректным форматом электронной почты
Предусловие:
1. Открыть браузер
2. Перейти по ссылке
   https://practice-automation.com/form-fields/

Шаги:
1.  Заполнить поле Name
2.  Поле Email заполнить **невалидным** значением pochta.mailru
3. Нажать на кнопку Submit

**Ожидаемый результат:** Успешного сабмита с алертом "Message received!" не происходит.

#### Тест-репорт Allure (к кейсу 3):
<img width="500" alt="image" src="https://github.com/user-attachments/assets/52f5dcd0-7e5c-4b1b-a30f-2a48b83f5803" />


#### Кейс 4 (негативный): попытка сабмита без указания имени
Предусловие:
1. Открыть браузер
2. Перейти по ссылке
   https://practice-automation.com/form-fields/

Шаги:
1. Заполнить поле Password
2. Поле Email заполнить строкой формата name@example.com
3. Поле Message заполнить значением "Nemo"

**Ожидаемый результат:** Успешного сабмита с алертом "Message received!" не происходит.
Возле поля Name появляется предупреждение с текстом о том, что поле обязательное.

#### Тест-репорт Allure (к кейсу 4):
<img width="500" alt="image" src="https://github.com/user-attachments/assets/ee221622-4031-4085-a424-7add65e4d34a" />


### Тест-репорт Allure (общий):
<img width="500" alt="image" src="https://github.com/user-attachments/assets/a2fac648-c525-4c7c-834c-c9bc500a75de" />
<img width="500" alt="image" src="https://github.com/user-attachments/assets/27900688-6138-4496-9d86-e0b3754f50d2" />
<img width="500" alt="image" src="https://github.com/user-attachments/assets/ac122673-26e0-443a-a1c6-6d671192faef" />


## Мои контакты
- Telegram: @longpastgone
- Email: akademuk97@gmail.com  

_Хочу в Simbirsoft!_
