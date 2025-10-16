# api-facturacion-mh

Proyecto Spring Boot (esqueleto) que reproduce servicios básicos para emisión de facturas (Ministerio de Hacienda - El Salvador).
Configuración por defecto:
- Java 21
- PostgreSQL: database `apimhdb` en localhost
- Usuario/clave por defecto: fesv_user / fesv_pass

## Ejecutar local
1. Crear la base de datos y usuario (se incluye `sql/create_db_apimhdb.sql`).
2. Configurar `src/main/resources/application.yml` si deseas cambiar credenciales.
3. Construir y correr:
   mvn clean package
   mvn spring-boot:run

## Endpoints principales
- POST /auth              -> Autenticación (form-data: user, pwd)
- POST /fesv/recepciondte -> Recepción síncrona de DTE (JSON)
- POST /fesv/recepcionlote -> Recepción de lote (JSON)
- GET  /fesv/consulta/{codigo} -> Consulta simplificada

Este proyecto es una base funcional (plantilla). Para producción necesitas:
- Hashear contraseñas (BCrypt)
- Añadir validaciones contra schemas JSON reales
- Implementar firma digital y certificados
