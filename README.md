# Conversor de Moneda

Este es un proyecto de consola en Java que permite realizar conversiones de moneda de forma dinámica. El sistema genera automáticamente un menú con todas las combinaciones posibles de monedas y permite al usuario seleccionar una opción, ingresar un valor y obtener el resultado de la conversión.

## Características
- **Menú dinámico**: Generación automática de combinaciones de monedas para conversión.
- **Validación de entrada**: Manejo robusto de errores para garantizar que las entradas sean válidas.
- **Cálculo preciso**: Realiza conversiones basadas en tasas de cambio configuradas.
- **Interfaz de consola**: Simple y fácil de usar, con opciones de salida seguras.

## Estructura del Proyecto
```
ConversorMoneda/
│
├── src/
│   ├── Application/
│   │   ├── FilterMoney.java
│   │   ├── MenuItem.java
│   │   ├── MenuSystem.java
│   │   └── ProcessExchangeRate.java
│   ├── Exchange/
│   │   ├── Conversion.java
│   │   ├── IConversion.java
│   │   └── Money.java
│   ├── HTTPRest/
│   │   └── Template/
│   │       ├── RExchangeRate.java
│   │       ├── ExchangeRate.java
│   │       ├── HttpRequestExchangeRate.java
│   │       └── HttpResponseExchangeRate.java
│   └── Main.java
│
├── README.md
└── .gitignore
```

## Requisitos
- **Java 11 o superior**
- **Gson** (para parseo de JSON)

## Instalación y Ejecución
1. **Clona el repositorio**:
   ```bash
   git clone https://github.com/soularius/currency-converter.git
   ```
2. **Compila el proyecto**:
   ```bash
   javac src/Main.java
   ```
3. **Ejecuta el proyecto**:
   ```bash
   java src/Main
   ```

## Uso
1. Al ejecutar el programa, se mostrará un menú con todas las combinaciones de monedas disponibles.
2. Selecciona una opción ingresando el número correspondiente.
3. Ingresa el valor que deseas convertir.
4. El programa calculará y mostrará el resultado formateado con dos decimales.
5. Para salir, selecciona la opción "Salir" del menú.

## Ejemplo de Salida
```
*************************************************
      Sea bienvenido/a al Conversor de Moneda =]
*************************************************
1) Dólar Estado Unidense => Peso Chileno
2) Dólar Estado Unidense => Peso Colombiano
3) Peso Chileno => Dólar Estado Unidense
4) Peso Chileno => Peso Colombiano
5) Peso Colombiano => Dólar Estado Unidense
6) Peso Colombiano => Peso Chileno
7) Salir
*************************************************
Elija una opción válida: 5
De: Peso Colombiano A: Dolar Estado Unidense
Ingrese el valor a convertir: 5666
El valor 5666.0 [COP] Corresponde al valor final de =>>> 1,29 [USD]
```

## Funcionalidades
- **MenuSystem**: Genera el menú y gestiona las opciones del usuario.
- **FilterMoney**: Inicializa las monedas disponibles y permite búsquedas.
- **Money**: Clase que representa una moneda con atributos como nombre, valor y descripción.
- **Calculo de cambio**: Realiza conversiones basadas en tasas establecidas.