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
#### Кейс 1: 
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
<img width="500" alt="image" src="https://github.com/user-attachments/assets/ae65dc01-1151-40c3-8ab3-45b8ea5a0fe4" />  
<img width="500" alt="image" src="https://github.com/user-attachments/assets/c2afeb86-aa87-42b1-aac0-c655b9e34250" />

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
<img width="500" alt="image" src="https://github.com/user-attachments/assets/25219f1b-4477-4d31-90ed-5dd568635d09" />

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
<img width="500" alt="image" src="https://github.com/user-attachments/assets/cd45b51e-dacc-4e64-a4c9-fc9fe487d30a" />

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
<img width="500" alt="image" src="https://github.com/user-attachments/assets/b5ee3623-098a-4c84-bffd-127a65bacdd0" />

### Тест-репорт Allure (общий):
<img width="500" alt="image" src="https://github.com/user-attachments/assets/5b75fa07-87b9-4fdd-9394-2fad0c9fee90" />
<img width="500" alt="image" src="https://github.com/user-attachments/assets/3c0f83d1-357d-46b7-9347-ecd3d7db1887" />
<img width="500" alt="image" src="https://github.com/user-attachments/assets/af1edae9-2f1f-4a3d-a427-f8e04c7c3455" />
<img width="500" alt="image" src="https://github.com/user-attachments/assets/0d3b967d-b8c3-41f6-96e4-13b5180fadeb" />

## Мои контакты
- Telegram: @longpastgone
- Email: akademuk97@gmail.com  

_Хочу в Simbirsoft!_
