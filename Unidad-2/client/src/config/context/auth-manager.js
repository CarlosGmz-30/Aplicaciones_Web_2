export const authManager = (action, state = { signed: false }) => {
    switch (action.type) {
        case "SIGNIN":
            return {
                ...action.payload,
                signed: true,
            };
        case "SIGNOUT":
            return {
                signed: false,
            }
        default:
            return state;
    }
}