fun main() {
  val yeison = Usuario(1, "Yeison", "Zapata", Rol.EDITOR, "yeison123")
	val juanes = Usuario(2, "Juan Esteban", "Isaza", Rol.VISITANTE, "juanes123")
	val alejandro = Usuario(3, "Alejandro", "Londoño", Rol.ADMIN, "admin123")

    GestorUsuarios.agregar(yeison)
    GestorUsuarios.agregar(juanes)
    GestorUsuarios.agregar(alejandro)

    if (alejandro.Autenticar("admin123")) {
    	alejandro.Autenticado()
	} else {
    	println("Contraseña incorrecta")
	}
    
    println("")
    
    if (alejandro.Autenticar("admin")) {
    	alejandro.Autenticado()
	} else {
    	println("Contraseña incorrecta")
	}
    
    println("")

    GestorUsuarios.validarRol(yeison)
    GestorUsuarios.validarRol(juanes)
    GestorUsuarios.validarRol(alejandro)
}

enum class Rol { 
    ADMIN,
    EDITOR,
    VISITANTE
}

interface Autenticable {
	fun Autenticar(contrasenaIngresada: String): Boolean
    fun Autenticado() = println("Usuario Autenticado con Exito")
}

data class Usuario(
    val id: Int,
    val nombre: String,
    val apellido: String,
    val rol: Rol,
    val contraseña : String
) : Autenticable {
    	override fun Autenticar(contrasenaIngresada: String): Boolean = contraseña == contrasenaIngresada
}


object GestorUsuarios {
    val usuarios = mutableListOf<Usuario>()

    fun agregar(usuario: Usuario) {
        usuarios.add(usuario)
    }

    fun validarRol(usuario: Usuario) {
        when (usuario.rol) {
            Rol.ADMIN -> println("Rol Admin, El usuario ${usuario.nombre} tiene acceso total")
            Rol.EDITOR -> println("Editor, El usuario ${usuario.nombre} puede editar contenido")
            Rol.VISITANTE -> println("Visitante, El usuario ${usuario.nombre} solo puede ver")
        }
    }
}






