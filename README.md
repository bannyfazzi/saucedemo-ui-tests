SauceDemo UI Automation Tests

Автоматизация тестирования функциональности логина на сайте  
https://www.saucedemo.com/ с использованием Java, Selenium и JUnit 5.

---

📌 <b>Описание проекта:</b>

В этом репозитории реализован небольшой фреймворк автоматизации UI-тестов для сайта SauceDemo с использованием Page Object Model (POM), Allure Reports и логирования.

Тесты проверяют поведение логина в разных сценариях:
- успешный логин  
- логин с неверным паролем  
- логин заблокированного пользователя  
- логин с пустыми полями  
- логин пользователя `performance_glitch_user` с проверкой корректного перехода

---

🚀 <b>Стек технологий:</b>

✔ Java  
✔ Selenium WebDriver  
✔ JUnit 5  
✔ Maven  
✔ Allure Reports  
✔ SLF4J + Logback  
✔ Page Object Model (POM)  

---

🧪 <b>Запуск тестов:</b>

Запуск в Chrome (по умолчанию):

```
mvn clean test
```

Запуск в FireFox:

```
mvn clean test -Dbrowser=firefox
```

<b>Запуск Allure отчёта локально:</b>

```
mvn allure:serve
```

Эта команда:

соберёт Allure отчёт, запустит локальный сервер и
откроет отчёт в браузере

<b>Генерация статического отчёта:</b>

```
mvn allure:report
```

<b>Отчёт будет создан в директории:</b>

```
target/site/allure-maven-plugin/index.html
```

🧠 <b>Логирование</b>

Логирование выполняется через SLF4J + Logback.
Формат логов прописан в logback.xml.

Пример входа:
```
15:23:45.123 INFO LoginPage - Вводим логин: standard_user
```

