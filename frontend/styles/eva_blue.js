import '@polymer/polymer/lib/elements/custom-style.js';
const documentContainer = document.createElement('template');
documentContainer.innerHTML = `
<custom-style>
  <style>

html {
  --lumo-font-size: 1rem;
  --lumo-font-size-xxxl: 1.375rem;
  --lumo-font-size-xxl: 1.125rem;
  --lumo-font-size-xl: 1rem;
  --lumo-font-size-l: 0.875rem;
  --lumo-font-size-m: 0.75rem;
  --lumo-font-size-s: 0.6875rem;
  --lumo-font-size-xs: 0.625rem;
  --lumo-font-size-xxs: 0.625rem;
  --lumo-line-height-m: 1.4;
  --lumo-line-height-s: 1.2;
  --lumo-line-height-xs: 1.1;
  --lumo-border-radius: 0.125em;
  --lumo-size-xl: 2.5rem;
  --lumo-size-l: 2rem;
  --lumo-size-m: 1.75rem;
  --lumo-size-s: 1.5rem;
  --lumo-size-xs: 1.25rem;
  --lumo-space-xl: 1.75rem;
  --lumo-space-l: 1.125rem;
  --lumo-space-m: 0.5rem;
  --lumo-space-s: 0.25rem;
  --lumo-space-xs: 0.125rem;
}

[theme~="dark"] {
  --lumo-shade-5pct: rgba(4, 7, 11, 0.05);
  --lumo-shade-10pct: rgba(4, 7, 11, 0.1);
  --lumo-shade-20pct: rgba(4, 7, 11, 0.2);
  --lumo-shade-30pct: rgba(4, 7, 11, 0.3);
  --lumo-shade-40pct: rgba(4, 7, 11, 0.4);
  --lumo-shade-50pct: rgba(4, 7, 11, 0.5);
  --lumo-shade-60pct: rgba(4, 7, 11, 0.6);
  --lumo-shade-70pct: rgba(4, 7, 11, 0.7);
  --lumo-shade-80pct: rgba(4, 7, 11, 0.8);
  --lumo-shade-90pct: rgba(4, 7, 11, 0.9);
  --lumo-shade: hsl(214, 47%, 3%);
}

  </style>
</custom-style>
`;
document.head.appendChild(documentContainer.content);
