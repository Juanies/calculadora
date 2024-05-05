TODO:
Roles

--> Usuario
--> Administrador

-- Para acceder a las funciones de administrador se debe tener el rol
-- de administrador y colocar una clave mediante la calculadora

Funciones usuario

--> Login Hecho vista |
--> Usar calculadora Hecho vista |

Funciones administrador

--> Lista de usuarios
--> Registro de nuevos usuarios
--> Cambio de contraseña de usuarios
--> Galeria de imagenes
--> Historial de Inicio de sesion
--> Historial de calculos

Cada vista tendrá su propio controlador. MVC en ningún momento indica que vista y controlador deban ser únicos. Para ser sincero pienso que el hecho de usar un controlador único para todo sería muy poco eficaz. Una cosa es la teoria y otra es la practica. Otra cosa es que uses un esqueleto único para el controlador y luego implementes distintas versiones del mismo con solo la implementación completa de los métodos necesarios en cada caso. Eso no rompe el paradigma pero si que simplifica y hace mucho mas claro el código.
