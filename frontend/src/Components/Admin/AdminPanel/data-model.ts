export class AdminPanelDataModel {
  private adminId: number;
  private role: string;

  constructor(adminId: number, role: string) {
    this.adminId = adminId;
    this.role = role;
  }

  public getAdminId(): number {
    return this.adminId;
  }

  public getRole(): string {
    return this.role;
  }
}