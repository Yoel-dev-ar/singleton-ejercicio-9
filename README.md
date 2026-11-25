Ejercicio 9: Sistema de Monitoreo de Métricas de Rendimiento

Contexto del problema: Una plataforma requiere un colector de métricas de rendimiento (uso de recursos y contadores de operaciones) que opere de manera transversal. Este colector debe recopilar datos de diferentes interceptores de red y componentes distribuidos en la arquitectura de software.

Objetivo de aprendizaje: Combinar el patrón Singleton con estructuras de agregación de datos y manejo eficiente de memoria bajo alta carga operativa.

Requisitos funcionales:

Registrar incrementos de contadores de rendimiento y tiempos de latencia desde cualquier punto de la aplicación.

Proveer un método de exportación que devuelva un resumen consolidado de todas las métricas acumuladas hasta el momento.

Restricciones técnicas:

El Singleton debe gestionar la sincronización de hilos de forma optimizada, evitando bloqueos excesivos globales.

La clase debe prevenir la pérdida de datos o desbordamiento de memoria mediante una estrategia interna de control de capacidad o limpieza de métricas cuando alcancen un umbral determinado.

# Ejercicio 9: Contador de Operaciones del Día (Patrón Singleton)

## Temática

Banca Digital y Tradicional — Consolidación centralizada de operaciones exitosas y fallidas del día.

## Consigna

El banco necesita llevar la cuenta diaria de todas las operaciones exitosas y con error realizadas en distintos canales, como cajeros y aplicación móvil, para que Gerencia pueda ver un resumen general consolidado. Si cada sector sumara en su propio contador por separado, el total del día quedaría dividido y no reflejaría la actividad real del banco.

El objetivo es aplicar el patrón Singleton para centralizar ambos contadores en una única instancia compartida, permitiendo sumar éxitos o errores desde cualquier canal y consultar el resumen total acumulado.

## Explicación lógica

1. Atributos: En la clase ContadorOperacionesDia se declaran operacionesExitosas (private int) para acumular las operaciones aprobadas y operacionesFallidas (private int) para contabilizar las que tuvieron error, junto con instancia (private static ContadorOperacionesDia), que va a conservar la única referencia en memoria para que todos los canales sumen sobre el mismo estado.


2. Instancia única: El constructor se define como private para impedir que otros módulos creen contadores independientes usando new, dejando ambos contadores en 0 cuando se crea por primera vez. El método getInstancia() controla el acceso: revisa si instancia es null (es decir, si todavía no se creó), la instancia una sola vez y en las siguientes llamadas devuelve siempre ese mismo objeto ya existente.


3. Asignación y Acceso: En Main, se obtiene la instancia desde dos canales (tableroCajeros y tableroApp) y se registran resultados con sumarExito() y sumarError(), incrementando el contador correspondiente en la instancia única. Luego, al invocar mostrarResumenDia() se imprime la cantidad de exitosas, de fallidas y el total procesado sumando ambos valores, mientras que la comparación tableroCajeros == tableroApp confirma que ambas variables apuntan exactamente al mismo objeto en memoria.



## Estructura del ejercicio

* ContadorOperacionesDia.java: Implementa el Singleton con los contadores de éxitos y errores y los métodos sumarExito(), sumarError() y mostrarResumenDia()
* Main.java: Registra operaciones desde cajeros y la app, muestra el resumen consolidado y verifica que comparten la misma instancia


