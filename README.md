# Cat Burger Shop 🍔🐱

**Cat Burger Shop** es un juego simple y divertido inspirado en el clásico *Burger Shop*, pero con un toque gatuno. Los jugadores deben preparar hamburguesas siguiendo los pedidos de los gatos antes de que se acabe el tiempo. ¡Cuidado! Los gatos pueden enfadarse si no les das lo que piden.

Este proyecto utiliza patrones de diseño como **Decorator**, **Observer** y **MVC**, además de implementar un sistema de guardado de puntajes usando **SharedPreferences**.

---

## Características principales 🎮

- **Temporizador**: El juego comienza con 30 segundos para completar cada pedido.
- **Pantalla de Game Over**: Cuando el tiempo se acaba, se muestra una pantalla de "Game Over" con la opción de reiniciar el juego.
- **Guardado de puntajes**: Los puntajes se guardan automáticamente usando SharedPreferences.
- **Interacción con gatos**: Los gatos tienen diferentes personalidades y reaccionan de manera única si no les das lo que piden.
- **Diseño modular**: El proyecto utiliza patrones de diseño como **Decorator**, **Observer** y **MVC** para una estructura limpia y mantenible.

---

## Cómo jugar 🕹️

1. **Iniciar el juego**: Al abrir la aplicación, se muestra una pantalla de inicio con dos botones: "Start Game" y "View Scores".
2. **Preparar hamburguesas**: Usa los ingredientes disponibles para preparar las hamburguesas que los gatos piden.
3. **Manejar el tiempo**: Tienes 30 segundos para completar cada pedido. Si el tiempo se acaba, el juego termina.
4. **Game Over**: Cuando el juego termina, se muestra una pantalla de "Game Over" con la opción de reiniciar.
5. **Ver puntajes**: Puedes ver tus puntajes guardados en la pantalla de inicio.

---

## Tecnologías y patrones utilizados 🛠️

- **Patrón Decorator**: Para agregar comportamientos adicionales a los gatos (por ejemplo, gatos con gorrito, gatos con lentes, etc.).
- **Patrón Observer**: Para notificar a los jugadores cuando los gatos se enfadan.
- **Patrón MVC (Model-View-Controller)**: Para separar la lógica del juego, la interfaz de usuario y el controlador.
- **SharedPreferences**: Para guardar y recuperar los puntajes del jugador.
- **Temporizador**: Implementado usando `Timer` y `TimerTask` para manejar el tiempo del juego.

---

## Requisitos del sistema 📋

- **Android Studio**: Versión 4.0 o superior.
- **Dispositivo Android**: Con Android 5.0 (Lollipop) o superior.

---

## Cómo ejecutar el proyecto 🚀

1. Clona este repositorio o descarga el código fuente.
2. Abre el proyecto en Android Studio.
3. Conecta un dispositivo Android o usa un emulador.
4. Haz clic en **Run** (el ícono de play) para compilar y ejecutar la aplicación.

---

¡Diviértete jugando y preparando hamburguesas para los gatitos :]! 🐾🍔
