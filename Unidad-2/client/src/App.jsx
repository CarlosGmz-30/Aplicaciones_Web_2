import { useEffect, useReducer } from "react";
import AuthContext from "./config/context/auth-context";
import { authManager } from "./config/context/auth-manager";
import AppRouter from "./router/AppRouter";
import "./output.css";
import "./assets/css/SignInPage.css";
import "./assets/css/Background.css";

const init = () => {
  return JSON.parse(localStorage.getItem("user"));
};

function App() {
  const [user, dispatch] = useReducer(authManager, {}, init);
  useEffect(() => {
    if (!user) return;
    localStorage.setItem("user", JSON.stringify(user));
  }, []);
  // React Fragment
  return (
    <AuthContext.Provider value={{ user, dispatch }}>
      <AppRouter />
    </AuthContext.Provider>
  );
}

export default App;
