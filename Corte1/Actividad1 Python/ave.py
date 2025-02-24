from datetime import datetime
from animal import Animal

class Ave(Animal):
    def __init__(self, nombre, peso, año_nacimiento, propietario):
        super().__init__(nombre, peso)
        self.año_nacimiento = año_nacimiento
        self.propietario = propietario

    @property
    def año_nacimiento(self):
        return self._año_nacimiento

    @año_nacimiento.setter
    def año_nacimiento(self, año_nacimiento):
        if año_nacimiento > 1900:
            self._año_nacimiento = año_nacimiento
        else:
            raise ValueError("Año de nacimiento no válido")

    @property
    def propietario(self):
        return self._propietario

    @propietario.setter
    def propietario(self, propietario):
        self._propietario = propietario

    def calcular_edad(self):
        año_actual = datetime.now().year
        return año_actual - self.año_nacimiento

    def es_mayor_de_edad(self):
        edad = self.calcular_edad()
        if edad >= 5:
            return f"{self.nombre} tiene {edad} años y es mayor de edad"
        else:
            return f"{self.nombre} tiene {edad} años y es menor de edad"
