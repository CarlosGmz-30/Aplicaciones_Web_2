export const authManager = (action, state = { signed: false }) => {
  switch (action.type) {
    case "SIGNIN":
      return {
        // Los 3 puntos es un operdador express
        // Manda todas la propiedades del objeto
        ...action.payload,
        signed: true,
      };
    case "SIGNOUT":
      return {
        signed: false,
      };
    default:
       return state;
  }
};
