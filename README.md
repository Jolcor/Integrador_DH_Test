# Proyecto Integrador: Pruebas Automatizadas con Selenium y RestAssured

## Objetivo

Este proyecto tiene como objetivo automatizar las pruebas de un sistema de banca en línea **Para Bank** utilizando **Java** y **Selenium**, junto con pruebas de la API usando **RestAssured**. El proyecto está diseñado para validar los procesos clave del sistema, como el registro de usuarios, apertura de cuentas, transferencias de fondos y consultas de actividad de cuenta.

## Tecnologías utilizadas

- **Java**: Lenguaje de programación principal.
- **Selenium**: Herramienta para automatizar la interacción con el navegador y pruebas de la interfaz de usuario (UI).
- **RestAssured**: Herramienta para realizar pruebas de APIs RESTful.
- **JUnit**: Framework para organizar las pruebas unitarias.
- **Maven**: Herramienta para la gestión de dependencias y construcción del proyecto.
- **Git**: Control de versiones.

## Estructura del Proyecto

- `src/test/java`: Contiene los scripts de prueba.
- `TestFrontEnd`: Pruebas automatizadas para la interfaz de usuario (UI) usando Selenium.
- `TestBackEnd`: Pruebas de la API utilizando RestAssured.
- `pom.xml`: Archivo de configuración de Maven con las dependencias necesarias para Selenium, RestAssured y JUnit.

## Casos de prueba implementados

### Pruebas Front-End (Interfaz de usuario)

1. **Registro de usuario**
   - Hacer clic en <Registro>.
   - Rellenar el formulario de registro con los datos requeridos.
   - Hacer clic en <Registrar> y verificar que el mensaje "Su cuenta se ha creado correctamente" sea visible.

2. **Apertura de una nueva cuenta**
   - Hacer clic en <Abrir nueva cuenta>.
   - Seleccionar el tipo de cuenta <Ahorros>.
   - Hacer clic en <Abrir nueva cuenta> y verificar que el mensaje "Congratulations, your account is now open" sea visible.

3. **Resumen de cuentas**
   - Hacer clic en <Resumen de cuentas> y verificar la visibilidad del texto "*El saldo incluye depósitos que pueden estar sujetos a retenciones".

4. **Transferencia de fondos**
   - Hacer clic en <Transferencia de fondos> y verificar que el texto "Transferir fondos" sea visible.
   - Introducir un importe, seleccionar cuentas y hacer clic en <Transferir>.
   - Verificar que el mensaje "¡Transferencia completa!" sea visible.

5. **Actividad de la cuenta**
   - Hacer clic en <Resumen de cuentas> y luego en una cuenta de la columna <Cuenta>.
   - Verificar que el texto "Detalles de la cuenta" sea visible.
   - Seleccionar filtros de actividad y hacer clic en <Ir>.

### Pruebas Back-End (API)

- **Registro**  
  Verificar el código de estado 200 para el endpoint de registro.  
  URL: `https://parabank.parasoft.com/parabank/register.htm`

- **Abrir una nueva cuenta**  
  Verificar el código de estado 200 para el endpoint de creación de cuenta.  
  URL: `https://parabank.parasoft.com/parabank/services_proxy/bank/createAccount?customerId=12545&newAccountType=1&fromAccountId=xxxxx`

- **Resumen de cuentas**  
  Verificar el código de estado 200 para el endpoint de resumen de cuentas.  
  URL: `https://parabank.parasoft.com/parabank/overview.htm`

- **Transferencia de fondos**  
  Verificar el código de estado 200 para el endpoint de transferencia de fondos.  
  URL: `https://parabank.parasoft.com/parabank/services_proxy/bank/transfer?fromAccountId=13566&toAccountId=13677&amount=xxxxx`

- **Actividad de la cuenta**  
  Verificar el código de estado 200 para el endpoint de actividad de la cuenta.  
  URL: `https://parabank.parasoft.com/parabank/services_proxy/bank/accounts/13566/transactions/month/All/type/All`
