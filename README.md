# Hoja de Trabajo 7: BST

### Autor: José Antonio Mérida Castejón - Carné 201105

Este programa implementa un diccionario Inglés - Español basado en asociaciones de palabras en Inglés y su traducción al Español. Estas asociaciones están guardadas en el archivo diccionario.txt, incluye las siguientes asociaciones y se puede modificar el archivo para agregar más utilizando el mismo formato.

```
(house,casa)
(dog,perro)
(homework,tarea)
(woman,mujer)
(town,pueblo)
(yes,si)
```

El programa puede imprimir el diccionario, recorriendo un BST de manera "In Order" o leer un archivo llamado texto.txt y reemplazar las palabras con su asociación en Español. El archivo texto.txt contiene el siguiente ejemplo y debe contener únicamente palabras sin puntuación alguna:

```
the woman in my town said my dog ate my homework
```

Teniendo como output la siguiente linea:

```
the mujer in my pueblo said my perro ate my tarea
```
## Instalación

Este proyecto utiliza [Maven](https://maven.apache.org/) y fue escrito en [Java](https://www.java.com/en/), por lo cual es necesario instalar estas dependencias para poder correr el programa.
