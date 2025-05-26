import '@vaadin/tooltip/theme/lumo/vaadin-tooltip.js';
import '@vaadin/polymer-legacy-adapter/style-modules.js';
import '@vaadin/button/theme/lumo/vaadin-button.js';
import 'Frontend/generated/jar-resources/disableOnClickFunctions.js';
import '@vaadin/vertical-layout/theme/lumo/vaadin-vertical-layout.js';
import '@vaadin/app-layout/theme/lumo/vaadin-drawer-toggle.js';
import '@vaadin/side-nav/theme/lumo/vaadin-side-nav.js';
import '@vaadin/icon/theme/lumo/vaadin-icon.js';
import '@vaadin/side-nav/theme/lumo/vaadin-side-nav-item.js';
import '@vaadin/icons/vaadin-iconset.js';
import '@vaadin/scroller/theme/lumo/vaadin-scroller.js';
import '@vaadin/app-layout/theme/lumo/vaadin-app-layout.js';
import '@vaadin/common-frontend/ConnectionIndicator.js';
import '@vaadin/vaadin-lumo-styles/color-global.js';
import '@vaadin/vaadin-lumo-styles/typography-global.js';
import '@vaadin/vaadin-lumo-styles/sizing.js';
import '@vaadin/vaadin-lumo-styles/spacing.js';
import '@vaadin/vaadin-lumo-styles/style.js';
import '@vaadin/vaadin-lumo-styles/vaadin-iconset.js';
import 'Frontend/generated/jar-resources/ReactRouterOutletElement.tsx';

const loadOnDemand = (key) => {
    const pending = [];
    if (key === '54ab22ff9b96ebe816b9e5f767e64a9a4a9968e5d2de4369a9d77afd4c8b31c6') {
        pending.push(import('./chunks/chunk-e878682a7e4336943089ffae70f7ee12b38f074ce5db348833d8ad4f498a8eee.js'));
    }
    if (key === '0da688b8e3bfeb652e449cc72bd45f86345bc01d5552baff1bb58ed90e66728b') {
        pending.push(import('./chunks/chunk-f803df643c07aa37eee57a440b68a91abb3cd3408a72bcc573024c04162131e4.js'));
    }
    if (key === '0d07195c7ac792d4319d5ff1b0550a41152b9f8559b4b70f5a81b1b0e6e5ff99') {
        pending.push(import('./chunks/chunk-2c3a0a72c266d0fe75cb1b0e5cfa0aa8cf9464858915fe3d6561775d151f77f2.js'));
    }
    if (key === '49e8caf5057fea257ebc6307910034b77ab59b66ae72b4bafdbc07081e01f269') {
        pending.push(import('./chunks/chunk-2fd42244bc0bd9493eca2789551c303c05ed538eaae7a701dfb862c63b9e8b3b.js'));
    }
    return Promise.all(pending);
}

window.Vaadin = window.Vaadin || {};
window.Vaadin.Flow = window.Vaadin.Flow || {};
window.Vaadin.Flow.loadOnDemand = loadOnDemand;
window.Vaadin.Flow.resetFocus = () => {
    let ae = document.activeElement;
    while (ae && ae.shadowRoot) ae = ae.shadowRoot.activeElement;
    return !ae || ae.blur() || ae.focus() || true;
}