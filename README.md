# Naufragio

Un grupo de piratas ha atacado a La Alianza en el Atlántico y ahora toda su tripulación se encuentra en peligro.

![barco](img/boat.jpg)

Sabemos que tenemos 5 balsas de rescate representadas en la siguiente tabla.

|   Balsa    | Capacidad | Tiempo de rescate
|:----------:|:---------:| :--:
|   Acasta   |     1     | 0.5 s
|   Banff    |     2     | 1 s
|   Cadiz    |     3     | 2 s
|   Deimos   |     4     | 4 s
| Expedición |     5     | 8 s

La **capacidad** indica el número de personas que es capaz de rescatar la balsa de rescate. 

El **tiempo de rescate** indica el tiempo que tarda en poder volver a rescatar gente.

## Rescate

Sabemos que La Alianza tiene 352 personas a bordo y se dividen en 4 categorias:

- Niños: Tienen prioridad 1
- Adultos: Tienen prioridad 2
- Ancianos: Tienen prioridad 3
- Tripulación: Tienen prioridad 4

Al realizar el rescate habrá que revisar la prioridad de la tripulacion y recoger a los que tengan la prioridad más baja.
Cuando una balsa este llena deberá indicar el nombre de la balsa y las ids de todos los que haya recogido.

## Actividad

Realiza un fork del repositorio y luego clona tu repositorio a local

Por buenas prácticas cada vez que se implenta una funcionalidad nueva hay que hacer un commit. Para esta práctica habra 
que hacer un commit cada vez que se modifique o añada un método. Ese commit deberá tener un nombre significativo.

Al finalizar la actividad se deberá hacer una pull request al repositorio original.
