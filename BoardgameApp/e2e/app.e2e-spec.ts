import { BoardgameAppPage } from './app.po';

describe('boardgame-app App', function() {
  let page: BoardgameAppPage;

  beforeEach(() => {
    page = new BoardgameAppPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
