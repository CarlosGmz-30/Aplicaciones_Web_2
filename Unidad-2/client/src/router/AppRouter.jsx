// Navegar entre componentes por medio de URL
import React from "react";
import { Button, Checkbox, Label, TextInput } from "flowbite-react";

const AppRouter = () => {
  return (
    <form id="form" className="flex max-w-md flex-col gap-4">
      <h1 id="title">INICIAR SESIÓN</h1>
      <div>
        <div className="mb-2 block">
          <Label htmlFor="email1" value="Correo Electrónico:" />
        </div>
        <TextInput
          id="email1"
          type="email"
          placeholder="Correo Electrónico"
          required
        />
      </div>
      <div>
        <div className="mb-2 block">
          <Label htmlFor="password1" value="Contraseña:" />
        </div>
        <TextInput
          id="password1"
          type="password"
          required
          placeholder="Contraseña"
        />
      </div>
      <div className="flex items-center gap-2">
        <Checkbox id="remember" />
        <Label htmlFor="remember">Recuérdame</Label>
      </div>
      <Button id="button" type="submit" gradientDuoTone="greenToBlue">
        Iniciar Sesión
      </Button>
    </form>
  );
};

export default AppRouter;
