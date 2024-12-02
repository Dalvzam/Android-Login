<h2>Proyecto: Aplicación Android de login basica</h2>

Este documento detalla las características, funcionalidades y pruebas realizadas en la aplicación, incluyendo explicaciones de las soluciones implementadas, su razonamiento, y los resultados esperados.

<h2>Explicación de la Solución</h2>
<h3>1. Descripción General</h3>

La aplicación consta de dos actividades principales:

--		MainActivity: Permite al usuario ingresar un nombre y navegar hacia ByeActivity.

--		ByeActivity: Muestra un mensaje personalizado de despedida y obtiene información meteorológica de Madrid desde un servicio web.

<h3>2. Razonamiento de las Elecciones</h3>

--		Arquitectura Simplicidad: Se usaron Intent para la comunicación entre actividades, y AsyncTask para la llamada a la API del clima.

<h2>Resultados Esperados</h2>

Funcionalidades Clave

<h3>MainActivity:</h3>

--		Permite al usuario ingresar un nombre y pasar a ByeActivity.

--		Muestra un mensaje de error si no se introduce un nombre.

<h3>ByeActivity:</h3>

--		Muestra un mensaje de despedida con el nombre proporcionado.

--		Realiza una llamada a una API para mostrar la temperatura actual en Madrid.

<h3>Resultados Verificados</h3>

--		La navegación entre actividades funciona según lo esperado.

-- 		Los mensajes de error se visualizan correctamente cuando es necesario.

--		Los datos meteorológicos se obtienen correctamente o se manejan errores de conexión.



<h2>Entornos y Circunstancias de Funcionamiento</h2>

<h3>1. Entornos Probados</h3>

Versiones de Android Compatibles:

--		Probado en dispositivos con android 15.0.   

Configuraciones de Pantalla:

--		Orientaciones: Vertical y Horizontal.

<h3>2. Limitaciones</h3>

-- 		Conexión a Internet requerida para obtener datos meteorológicos.

--		Adaptación básica para pantallas plegables y tablets.

<h2>Compatibilidad Multi-Dispositivo</h2>

<h3>Dispositivos Probados</h3>

--		Medium Phone API 35

--		Pixel Tablet API 35.

<h2>Lógica de Negocio y Parámetros</h2>

<h3>Consideraciones Implementadas</h3>

1. Parámetro de Entrada:

--		Nombre del usuario proporcionado en MainActivity.

--		Validación para evitar valores nulos o vacíos.

Llamada a la API del Clima:

--		URL dinámica para obtener información meteorológica.

--		Manejo de errores como tiempo de espera o falta de conexión.

Resultados:

--		Personalización del mensaje en ByeActivity.

--		Visualización de datos meteorológicos o mensajes de error claros.














   
