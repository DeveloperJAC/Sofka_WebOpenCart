# language: es
@FeatureName:RegistrarNuevaCuenta
Característica: Registrar nueva cuenta
  Como cliente en línea
  necesito crear una cuenta
  para poder realizar compras en la tienda web.

  @ScenarioName:IngresarModuloRegistro
  Escenario: Ingresar al modulo de registro de cuenta.
    Dado que el cliente esta en la página de inicio.
    Cuando el cliente ingresa al la seccion de mi cuenta da click en registrar.
    Entonces como resultado el usuario vera el formulario de registro.

