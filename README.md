# Teoria_de_la_Informacion

<h1>Instrucciones para poder compilar la aplicacion: </h1>
<ul>
  <li>Eclipse: Una vez abierto el IDE, click derecho en el <em>Package Explorer</em>, luego seleccionar la opcion <em>Import</em>. Se desplegara una ventana, en la que se debe seleccionar <em>Maven -> Existing Maven Projects</em>. Una vez seleccionado eso, pulsar <em>Next</em>. Se abrira una nueva ventana con el titulo <em>Import Maven Projects</em>. Se debe buscar la direccion donde se tiene descargado el projecto (El que se llama Teoria_de_la_informacion). Se selecciona y se pulsa aceptar. Verificar que en el recuadro de Projects este tildado. Luego, pulsar finish. Una vez que termina de importarse el projecto, ir a TrabajoPracticoIntegrador1 -> src/main/java -> main -> Main.java. Una vez alli hacer click en el run.</li>
</ul>


<h1>Instrucciones para compilar la aplicacion en el caso de que falle en Eclipse: </h1>

<ol>
  <li> Clonar el proyecto desde HTTP o SSH </li>
  <li> Abrir el proyecto con algun IDE que permita compilar JAVA (IntelliJ, Eclipse, Netbeans) </li>
  <li> 
    Probar realizar el build desde la IDE elegida. En caso que falle por no reconocer algun archivo o import de paquete, se debera realizar un Rebuild del proyecto, siguiendo los siguientes pasos: IntelliJ
    <ol>
      <li> En el caso de Intellij, en el Menu bar indicado en la parte superior de la aplicacion, clickear en la tab <em>Build</em>. Una vez abierta la solapa, clickear <em>Rebuild project</em>. Correr el proyecto.
      <li> En el caso de Eclipse, clickear en la tab <em>Project</em> y, una vez que se abra la solapa, clickear en la opcion <em>Clean</em>. Correr el proyecto</li>
    </ol>
  </li>
</ol>


<p> Si los inconvenientes persisten luego de realizar los pasos indicados, se puede ejecutar la aplicacion desde el .jar contenido en la carpeta <b>Ejecutables</b> que se encuentra en la carpeta descargada al realizar el <em>Clone</em>. </p>


<h2>Instrucciones para leer el codigo: </h2>

<p>
  El proyecto se encuentra distribuido en 3 paquetes principales:
  <ul>
    <li><b>back</b></li>
    <li><b>front</b></li>
    <li><b>main</b></li>
  </ul>
</p>

<h3>Paquete back: </h3>
<p>
  El paquete back se encuentra subdividido en 4 paquetes:
  <ul>
    <li><b>presentation:</b> Aqui yace la interfaz que funciona como punto de acceso para el controlador, para asi poder comunicar la logica de negocios con el controlador de la visual.</li>
    <li><b>actions:</b> En este paquete se pueden encontrar los metodos que recopilan la informacion paso por paso para ir resolviendo cada ejercicio </li>
    <li><b>domain:</b> Esta dividido en dos paquetes:
      <ul>
        <li><b>calculadoras</b>: En este paquete se encuentran todas las calculadoras encargadas de obtener los valores correspondientes a cada ejercicio. Aqui se puede encontrar la logica para calcular cantidad de informacion, entropia, generacion de simulaciones, etc..</b></li>
    <li><b>formatters:</b> En este paquete se puede encontrar los formatters, que son quienes se encargan de generar los textos que son mostrados en la visual, para poder visualizar los resultados de una forma correcta y legible.</li>
      </ul>
    </li>
    <li><b>infrastructure:</b> Aqui se encuentra el lector de archivo que se encarga de leer la matriz de probabilidades o el vector de probabilidades, si es que se elige la opcion de archivo en la visual.</li>
  </ul>
</p>



<h3>Paquete front: </h3>
<p>
  El paquete front se encuentra subdividido en 2 paquetes:
  <ul>
    <li><b>controlador:</b> Aqui se puede encontrar el controlador de la visual de la aplicacion, que es quien comunica las interacciones del usuario con la logica de negocios, ubicada en el paquete <em>back</em>.</li>
    <li><b>views:</b> Aqui se encuentra la visual que es la encargada de recibir las interacciones del usuario y comunicarselas al controlador.</li>
</ul>
</p>



<h3>Paquete main: </h3>
<p>
   En este paquete se encuentra una sola clase que representa al main de la aplicacion, el cual se encarga de correr la app mostrando la visual ubicada en el paquete <em>front/views</em>
</p>
