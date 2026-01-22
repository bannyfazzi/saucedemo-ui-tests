SauceDemo UI Automation Tests

Автоматизация тестирования функциональности логина на сайте  
https://www.saucedemo.com/ с использованием Java, Selenium и JUnit 5.

---

📌 Описание проекта:

В этом репозитории реализован небольшой фреймворк автоматизации UI-тестов для сайта SauceDemo с использованием Page Object Model (POM), Allure Reports и логирования.

Тесты проверяют поведение логина в разных сценариях:
- успешный логин  
- логин с неверным паролем  
- логин заблокированного пользователя  
- логин с пустыми полями  
- логин пользователя `performance_glitch_user` с проверкой корректного перехода

---

🚀 Стек технологий:

✔ Java  
✔ Selenium WebDriver  
✔ JUnit 5  
✔ Maven  
✔ Allure Reports  
✔ SLF4J + Logback  
✔ Page Object Model (POM)  
✔ Мульти-браузерный запуск через system property  

---

🗂 Структура проекта:

saucedemo-ui-tests/
├── .gitignore
├── pom.xml
├── logback.xml
├── src/
│ └── test/
│ └── java/
│ ├── base/ базовый тестовый класс
│ ├── pages/ Page Object классы
│ ├── tests/ тестовые класс
│ └── utils/ утилита (DriverFactory)
└── allure-results/ результаты Allure (генерируются при запуске)


---

🧪 Запуск тестов:

Запуск в Chrome (по умолчанию):

```bash
mvn clean test

Запуск в FireFox:

```bash
mvn clean test -Dbrowser=firefox

Запуск Allure отчёта локально:

```bash
mvn allure:serve

Эта команда:

соберёт Allure отчёт
запустит локальный сервер
откроет отчёт в браузере

Генерация статического отчёта:

```bash
mvn allure:report

Отчёт будет создан в директории:

```bash
target/site/allure-maven-plugin/index.html

🧠 Логирование

Логирование выполняется через SLF4J + Logback.
Формат логов прописан в logback.xml.

Пример входа:

15:23:45.123 INFO LoginPage - Вводим логин: standard_user
