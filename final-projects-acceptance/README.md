# בדיקות קבלה - מערכת פרויקטי גמר

בדיקות קבלה (JUnit 4) לשני סיפורי משתמש: הוספת פרויקט ורישום לפרויקט.
המערכת עצמה עוד לא קיימת, ולכן הבדיקות רצות מול stub (`ProxyBridge`).

## מה צריך
- Java 17 ומעלה
- Maven

## הרצה
```
mvn test
```

## הרצה מול המערכת האמיתית (כשתהיה)
```
mvn test -Dbridge.real=<שם המחלקה המלא של הגשר האמיתי>
```

## מבנה
- `acceptance/bridge/ProjectSystemBridge.java` - הממשק (Interface Bridge)
- `acceptance/bridge/ProxyBridge.java` - מימוש זמני (stub)
- `acceptance/bridge/Driver.java` - בוחר איזה מימוש הבדיקות מקבלות
- `acceptance/tests/` - הבדיקות
