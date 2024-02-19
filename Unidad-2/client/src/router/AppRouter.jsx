// Navegar entre componentes por medio de URL
import React from "react";
import { SignInPage } from "../modules/auth/SignInPage";
import AuthContext from "../config/context/auth-context";
import {
  Route,
  createBrowserRouter,
  createRoutesFromElements,
} from "react-router-dom";

const AppRouter = () => {
  const { user } = useContext(AuthContext);
  const router = createBrowserRouter(
    createRoutesFromElements(
      <>
        {
          user.signed ?
            <>
              <Route path="/" element={<>Admin Layout</>}>
                <Route path="dashboard" element={<>Dashboard</>} />
                <Route path="user" element={<>Dashboard</>} />
                <Route path="products" element={<>Dashboard</>} />
              </Route>
            </> :
            <Route path="/" element={<SignInPage />} />
        }
        <Route path="/" element={<>404 not found</>} />
      </>
    ));
  return;
  <></>;
};

export default AppRouter;
