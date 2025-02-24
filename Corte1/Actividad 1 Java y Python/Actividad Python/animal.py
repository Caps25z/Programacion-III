class Animal:
    def __init__(self, nombre, peso):
        self.nombre = nombre
        self.peso = peso

    @property
    def nombre(self):
        return self._nombre

    @nombre.setter
    def nombre(self, nombre):
        self._nombre = nombre

    @property
    def peso(self):
        return self._peso

    @peso.setter
    def peso(self, peso):
        if peso > 0:
            self._peso = peso
        else:
            raise ValueError("El peso debe ser mayor a 0")
